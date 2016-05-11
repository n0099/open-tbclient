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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class r extends FrameLayout implements View.OnClickListener {
    private boolean aFp;
    private TextView aOG;
    private com.baidu.tieba.tbadkCore.data.a dsS;
    private TbImageView dsT;
    private LinearLayout dsU;
    private ImageView dsV;
    private TextView dsW;
    private Context mContext;
    private View mRootView;

    public r(Context context) {
        this(context, null, 0);
    }

    public r(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aFp = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.dsS;
    }

    public void Ho() {
        this.aFp = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(t.h.pic_show_cardview_layout, (ViewGroup) this, true);
        this.dsT = (TbImageView) findViewById(t.g.pic_img);
        this.dsU = (LinearLayout) findViewById(t.g.bottom_ll);
        this.aOG = (TextView) findViewById(t.g.title_ll);
        this.dsW = (TextView) findViewById(t.g.desc_ll);
        this.dsV = (ImageView) findViewById(t.g.show_pic_icon);
    }

    public void setIconResId(int i) {
        at.c(this.dsV, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.dsS != aVar) {
            this.dsS = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.aOG.setVisibility(0);
                this.aOG.setText(aVar.getTitle());
            } else {
                this.aOG.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.dsW.setVisibility(0);
                this.dsW.setText(aVar.getDescription());
            } else {
                this.dsW.setVisibility(8);
            }
            if (this.aFp) {
                this.dsT.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.dsT.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.dsT.setOnClickListener(this);
                this.dsT.setInterceptOnClick(true);
                this.dsT.setDefaultResource(t.f.icon_click);
                this.dsT.c(aVar.aTk(), 18, false);
                int B = com.baidu.adp.lib.util.k.B(this.mContext) - (com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (B * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (B * 0.75f);
                } else {
                    i = (int) (f * B);
                }
                this.dsT.setLayoutParams(new FrameLayout.LayoutParams(B, i));
                removeView(this.dsT);
                addView(this.dsT);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dsU.getLayoutParams();
                layoutParams.width = B;
                layoutParams.height = com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds110);
                removeView(this.dsU);
                addView(this.dsU, layoutParams);
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().ae(i == 1);
        tbPageContext.getLayoutMode().x(this.mRootView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dsS != null) {
            com.baidu.tbadk.browser.f.t(this.mContext, this.dsS.aTl());
        }
    }

    public ImageView getIcon() {
        return this.dsV;
    }
}
