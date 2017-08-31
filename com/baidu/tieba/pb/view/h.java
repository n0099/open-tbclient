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
    private boolean aRM;
    private LinearLayout cks;
    private com.baidu.tieba.tbadkCore.data.a faL;
    private TbImageView faM;
    private ImageView faN;
    private TextView faO;
    private Context mContext;
    private View mRootView;
    private TextView mTitle;

    public h(Context context) {
        this(context, null, 0);
    }

    public h(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aRM = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.faL;
    }

    public void Jk() {
        this.aRM = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.j.pic_show_cardview_layout, (ViewGroup) this, true);
        this.faM = (TbImageView) findViewById(d.h.pic_img);
        this.cks = (LinearLayout) findViewById(d.h.bottom_ll);
        this.mTitle = (TextView) findViewById(d.h.title_ll);
        this.faO = (TextView) findViewById(d.h.desc_ll);
        this.faN = (ImageView) findViewById(d.h.show_pic_icon);
    }

    public void setIconResId(int i) {
        aj.c(this.faN, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.faL != aVar) {
            this.faL = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(aVar.getTitle());
            } else {
                this.mTitle.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.faO.setVisibility(0);
                this.faO.setText(aVar.getDescription());
            } else {
                this.faO.setVisibility(8);
            }
            if (this.aRM) {
                this.faM.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.faM.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.faM.setOnClickListener(this);
                this.faM.setInterceptOnClick(true);
                this.faM.setDefaultResource(d.g.icon_click);
                this.faM.c(aVar.brJ(), 18, false);
                int ad = k.ad(this.mContext) - (k.g(this.mContext, d.f.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (ad * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (ad * 0.75f);
                } else {
                    i = (int) (f * ad);
                }
                this.faM.setLayoutParams(new FrameLayout.LayoutParams(ad, i));
                removeView(this.faM);
                addView(this.faM);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cks.getLayoutParams();
                layoutParams.width = ad;
                layoutParams.height = k.g(this.mContext, d.f.ds110);
                removeView(this.cks);
                addView(this.cks, layoutParams);
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().ah(i == 1);
        tbPageContext.getLayoutMode().t(this.mRootView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.faL != null) {
            com.baidu.tbadk.browser.a.T(this.mContext, this.faL.brK());
        }
    }

    public ImageView getIcon() {
        return this.faN;
    }
}
