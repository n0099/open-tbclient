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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class l extends FrameLayout implements View.OnClickListener {
    private boolean aIj;
    private TextView aNb;
    private ImageView euA;
    private TextView euB;
    private com.baidu.tieba.tbadkCore.data.a eux;
    private TbImageView euy;
    private LinearLayout euz;
    private Context mContext;
    private View mRootView;

    public l(Context context) {
        this(context, null, 0);
    }

    public l(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aIj = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.eux;
    }

    public void Id() {
        this.aIj = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(r.j.pic_show_cardview_layout, (ViewGroup) this, true);
        this.euy = (TbImageView) findViewById(r.h.pic_img);
        this.euz = (LinearLayout) findViewById(r.h.bottom_ll);
        this.aNb = (TextView) findViewById(r.h.title_ll);
        this.euB = (TextView) findViewById(r.h.desc_ll);
        this.euA = (ImageView) findViewById(r.h.show_pic_icon);
    }

    public void setIconResId(int i) {
        ap.c(this.euA, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.eux != aVar) {
            this.eux = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.aNb.setVisibility(0);
                this.aNb.setText(aVar.getTitle());
            } else {
                this.aNb.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.euB.setVisibility(0);
                this.euB.setText(aVar.getDescription());
            } else {
                this.euB.setVisibility(8);
            }
            if (this.aIj) {
                this.euy.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.euy.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.euy.setOnClickListener(this);
                this.euy.setInterceptOnClick(true);
                this.euy.setDefaultResource(r.g.icon_click);
                this.euy.c(aVar.bhi(), 18, false);
                int I = com.baidu.adp.lib.util.k.I(this.mContext) - (com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (I * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (I * 0.75f);
                } else {
                    i = (int) (f * I);
                }
                this.euy.setLayoutParams(new FrameLayout.LayoutParams(I, i));
                removeView(this.euy);
                addView(this.euy);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.euz.getLayoutParams();
                layoutParams.width = I;
                layoutParams.height = com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds110);
                removeView(this.euz);
                addView(this.euz, layoutParams);
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().ai(i == 1);
        tbPageContext.getLayoutMode().v(this.mRootView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eux != null) {
            com.baidu.tbadk.browser.f.u(this.mContext, this.eux.bhj());
        }
    }

    public ImageView getIcon() {
        return this.euA;
    }
}
