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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class h extends FrameLayout implements View.OnClickListener {
    private boolean aSx;
    private LinearLayout ckU;
    private com.baidu.tieba.tbadkCore.data.a eVB;
    private TbImageView eVC;
    private ImageView eVD;
    private TextView eVE;
    private Context mContext;
    private View mRootView;
    private TextView mTitle;

    public h(Context context) {
        this(context, null, 0);
    }

    public h(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aSx = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.eVB;
    }

    public void Jn() {
        this.aSx = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.j.pic_show_cardview_layout, (ViewGroup) this, true);
        this.eVC = (TbImageView) findViewById(d.h.pic_img);
        this.ckU = (LinearLayout) findViewById(d.h.bottom_ll);
        this.mTitle = (TextView) findViewById(d.h.title_ll);
        this.eVE = (TextView) findViewById(d.h.desc_ll);
        this.eVD = (ImageView) findViewById(d.h.show_pic_icon);
    }

    public void setIconResId(int i) {
        aj.c(this.eVD, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.eVB != aVar) {
            this.eVB = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(aVar.getTitle());
            } else {
                this.mTitle.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.eVE.setVisibility(0);
                this.eVE.setText(aVar.getDescription());
            } else {
                this.eVE.setVisibility(8);
            }
            if (this.aSx) {
                this.eVC.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.eVC.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.eVC.setOnClickListener(this);
                this.eVC.setInterceptOnClick(true);
                this.eVC.setDefaultResource(d.g.icon_click);
                this.eVC.c(aVar.bqK(), 18, false);
                int ad = l.ad(this.mContext) - (l.f(this.mContext, d.f.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (ad * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (ad * 0.75f);
                } else {
                    i = (int) (f * ad);
                }
                this.eVC.setLayoutParams(new FrameLayout.LayoutParams(ad, i));
                removeView(this.eVC);
                addView(this.eVC);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ckU.getLayoutParams();
                layoutParams.width = ad;
                layoutParams.height = l.f(this.mContext, d.f.ds110);
                removeView(this.ckU);
                addView(this.ckU, layoutParams);
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().ah(i == 1);
        tbPageContext.getLayoutMode().t(this.mRootView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eVB != null) {
            com.baidu.tbadk.browser.a.O(this.mContext, this.eVB.bqL());
        }
    }

    public ImageView getIcon() {
        return this.eVD;
    }
}
