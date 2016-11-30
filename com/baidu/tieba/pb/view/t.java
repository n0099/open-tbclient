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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.f;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class t extends FrameLayout implements View.OnClickListener {
    private boolean aKl;
    private TextView aOH;
    private com.baidu.tieba.tbadkCore.data.a eGM;
    private TbImageView eGN;
    private LinearLayout eGO;
    private ImageView eGP;
    private TextView eGQ;
    private Context mContext;
    private View mRootView;

    public t(Context context) {
        this(context, null, 0);
    }

    public t(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aKl = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.eGM;
    }

    public void IR() {
        this.aKl = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(r.h.pic_show_cardview_layout, (ViewGroup) this, true);
        this.eGN = (TbImageView) findViewById(r.g.pic_img);
        this.eGO = (LinearLayout) findViewById(r.g.bottom_ll);
        this.aOH = (TextView) findViewById(r.g.title_ll);
        this.eGQ = (TextView) findViewById(r.g.desc_ll);
        this.eGP = (ImageView) findViewById(r.g.show_pic_icon);
    }

    public void setIconResId(int i) {
        at.c(this.eGP, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.eGM != aVar) {
            this.eGM = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.aOH.setVisibility(0);
                this.aOH.setText(aVar.getTitle());
            } else {
                this.aOH.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.eGQ.setVisibility(0);
                this.eGQ.setText(aVar.getDescription());
            } else {
                this.eGQ.setVisibility(8);
            }
            if (this.aKl) {
                this.eGN.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.eGN.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.eGN.setOnClickListener(this);
                this.eGN.setInterceptOnClick(true);
                this.eGN.setDefaultResource(r.f.icon_click);
                this.eGN.c(aVar.blD(), 18, false);
                int K = com.baidu.adp.lib.util.k.K(this.mContext) - (com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (K * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (K * 0.75f);
                } else {
                    i = (int) (f * K);
                }
                this.eGN.setLayoutParams(new FrameLayout.LayoutParams(K, i));
                removeView(this.eGN);
                addView(this.eGN);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eGO.getLayoutParams();
                layoutParams.width = K;
                layoutParams.height = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds110);
                removeView(this.eGO);
                addView(this.eGO, layoutParams);
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().ai(i == 1);
        tbPageContext.getLayoutMode().x(this.mRootView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eGM != null) {
            f.u(this.mContext, this.eGM.blE());
        }
    }

    public ImageView getIcon() {
        return this.eGP;
    }
}
