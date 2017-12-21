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
    private boolean aUz;
    private LinearLayout cBJ;
    private com.baidu.tieba.tbadkCore.data.a fmo;
    private TbImageView fmp;
    private ImageView fmq;
    private TextView fmr;
    private Context mContext;
    private View mRootView;
    private TextView mTitle;

    public h(Context context) {
        this(context, null, 0);
    }

    public h(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aUz = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.fmo;
    }

    public void Jq() {
        this.aUz = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.pic_show_cardview_layout, (ViewGroup) this, true);
        this.fmp = (TbImageView) findViewById(d.g.pic_img);
        this.cBJ = (LinearLayout) findViewById(d.g.bottom_ll);
        this.mTitle = (TextView) findViewById(d.g.title_ll);
        this.fmr = (TextView) findViewById(d.g.desc_ll);
        this.fmq = (ImageView) findViewById(d.g.show_pic_icon);
    }

    public void setIconResId(int i) {
        aj.c(this.fmq, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.fmo != aVar) {
            this.fmo = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(aVar.getTitle());
            } else {
                this.mTitle.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.fmr.setVisibility(0);
                this.fmr.setText(aVar.getDescription());
            } else {
                this.fmr.setVisibility(8);
            }
            if (this.aUz) {
                this.fmp.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.fmp.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.fmp.setOnClickListener(this);
                this.fmp.setInterceptOnClick(true);
                this.fmp.setDefaultResource(d.f.icon_click);
                this.fmp.startLoad(aVar.bwr(), 18, false);
                int ac = l.ac(this.mContext) - (l.f(this.mContext, d.e.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (ac * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (ac * 0.75f);
                } else {
                    i = (int) (f * ac);
                }
                this.fmp.setLayoutParams(new FrameLayout.LayoutParams(ac, i));
                removeView(this.fmp);
                addView(this.fmp);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cBJ.getLayoutParams();
                layoutParams.width = ac;
                layoutParams.height = l.f(this.mContext, d.e.ds110);
                removeView(this.cBJ);
                addView(this.cBJ, layoutParams);
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().ag(i == 1);
        tbPageContext.getLayoutMode().t(this.mRootView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fmo != null) {
            com.baidu.tbadk.browser.a.O(this.mContext, this.fmo.bws());
        }
    }

    public ImageView getIcon() {
        return this.fmq;
    }
}
