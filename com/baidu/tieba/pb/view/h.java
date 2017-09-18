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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class h extends FrameLayout implements View.OnClickListener {
    private boolean aRJ;
    private LinearLayout clk;
    private com.baidu.tieba.tbadkCore.data.a fbF;
    private TbImageView fbG;
    private ImageView fbH;
    private TextView fbI;
    private Context mContext;
    private View mRootView;
    private TextView mTitle;

    public h(Context context) {
        this(context, null, 0);
    }

    public h(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aRJ = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.fbF;
    }

    public void Jk() {
        this.aRJ = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.j.pic_show_cardview_layout, (ViewGroup) this, true);
        this.fbG = (TbImageView) findViewById(d.h.pic_img);
        this.clk = (LinearLayout) findViewById(d.h.bottom_ll);
        this.mTitle = (TextView) findViewById(d.h.title_ll);
        this.fbI = (TextView) findViewById(d.h.desc_ll);
        this.fbH = (ImageView) findViewById(d.h.show_pic_icon);
    }

    public void setIconResId(int i) {
        aj.c(this.fbH, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.fbF != aVar) {
            this.fbF = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(aVar.getTitle());
            } else {
                this.mTitle.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.fbI.setVisibility(0);
                this.fbI.setText(aVar.getDescription());
            } else {
                this.fbI.setVisibility(8);
            }
            if (this.aRJ) {
                this.fbG.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.fbG.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.fbG.setOnClickListener(this);
                this.fbG.setInterceptOnClick(true);
                this.fbG.setDefaultResource(d.g.icon_click);
                this.fbG.c(aVar.brU(), 18, false);
                int ae = k.ae(this.mContext) - (k.f(this.mContext, d.f.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (ae * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (ae * 0.75f);
                } else {
                    i = (int) (f * ae);
                }
                this.fbG.setLayoutParams(new FrameLayout.LayoutParams(ae, i));
                removeView(this.fbG);
                addView(this.fbG);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.clk.getLayoutParams();
                layoutParams.width = ae;
                layoutParams.height = k.f(this.mContext, d.f.ds110);
                removeView(this.clk);
                addView(this.clk, layoutParams);
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().ah(i == 1);
        tbPageContext.getLayoutMode().t(this.mRootView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fbF != null) {
            com.baidu.tbadk.browser.a.T(this.mContext, this.fbF.brV());
        }
    }

    public ImageView getIcon() {
        return this.fbH;
    }
}
