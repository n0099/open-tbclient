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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class l extends FrameLayout implements View.OnClickListener {
    private boolean aGt;
    private TextView aPr;
    private com.baidu.tieba.tbadkCore.data.a cVT;
    private TbImageView cVU;
    private LinearLayout cVV;
    private ImageView cVW;
    private TextView cVX;
    private Context mContext;
    private View mRootView;

    public l(Context context) {
        this(context, null, 0);
    }

    public l(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aGt = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.cVT;
    }

    public void HC() {
        this.aGt = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(t.h.pic_show_cardview_layout, (ViewGroup) this, true);
        this.cVU = (TbImageView) findViewById(t.g.pic_img);
        this.cVV = (LinearLayout) findViewById(t.g.bottom_ll);
        this.aPr = (TextView) findViewById(t.g.title_ll);
        this.cVX = (TextView) findViewById(t.g.desc_ll);
        this.cVW = (ImageView) findViewById(t.g.show_pic_icon);
    }

    public void setIconResId(int i) {
        ar.c(this.cVW, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.cVT != aVar) {
            this.cVT = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.aPr.setVisibility(0);
                this.aPr.setText(aVar.getTitle());
            } else {
                this.aPr.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.cVX.setVisibility(0);
                this.cVX.setText(aVar.getDescription());
            } else {
                this.cVX.setVisibility(8);
            }
            if (this.aGt) {
                this.cVU.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.cVU.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.cVU.setOnClickListener(this);
                this.cVU.setInterceptOnClick(true);
                this.cVU.setDefaultResource(t.f.icon_click);
                this.cVU.d(aVar.aLP(), 18, false);
                int K = com.baidu.adp.lib.util.k.K(this.mContext) - (com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (K * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (K * 0.75f);
                } else {
                    i = (int) (f * K);
                }
                this.cVU.setLayoutParams(new FrameLayout.LayoutParams(K, i));
                removeView(this.cVU);
                addView(this.cVU);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cVV.getLayoutParams();
                layoutParams.width = K;
                layoutParams.height = com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds110);
                removeView(this.cVV);
                addView(this.cVV, layoutParams);
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().ac(i == 1);
        tbPageContext.getLayoutMode().x(this.mRootView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cVT != null) {
            com.baidu.tbadk.browser.f.B(this.mContext, this.cVT.aLQ());
        }
    }

    public ImageView getIcon() {
        return this.cVW;
    }
}
