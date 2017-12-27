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
/* loaded from: classes2.dex */
public class h extends FrameLayout implements View.OnClickListener {
    private boolean bIm;
    private LinearLayout dqm;
    private com.baidu.tieba.tbadkCore.data.a fZj;
    private TbImageView fZk;
    private TextView fZl;
    private ImageView jt;
    private Context mContext;
    private View mRootView;
    private TextView mTitle;

    public h(Context context) {
        this(context, null, 0);
    }

    public h(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bIm = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.fZj;
    }

    public void QM() {
        this.bIm = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.pic_show_cardview_layout, (ViewGroup) this, true);
        this.fZk = (TbImageView) findViewById(d.g.pic_img);
        this.dqm = (LinearLayout) findViewById(d.g.bottom_ll);
        this.mTitle = (TextView) findViewById(d.g.title_ll);
        this.fZl = (TextView) findViewById(d.g.desc_ll);
        this.jt = (ImageView) findViewById(d.g.show_pic_icon);
    }

    public void setIconResId(int i) {
        aj.c(this.jt, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.fZj != aVar) {
            this.fZj = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(aVar.getTitle());
            } else {
                this.mTitle.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.fZl.setVisibility(0);
                this.fZl.setText(aVar.getDescription());
            } else {
                this.fZl.setVisibility(8);
            }
            if (this.bIm) {
                this.fZk.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.fZk.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.fZk.setOnClickListener(this);
                this.fZk.setInterceptOnClick(true);
                this.fZk.setDefaultResource(d.f.icon_click);
                this.fZk.startLoad(aVar.bBG(), 18, false);
                int ao = l.ao(this.mContext) - (l.s(this.mContext, d.e.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (ao * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (ao * 0.75f);
                } else {
                    i = (int) (f * ao);
                }
                this.fZk.setLayoutParams(new FrameLayout.LayoutParams(ao, i));
                removeView(this.fZk);
                addView(this.fZk);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dqm.getLayoutParams();
                layoutParams.width = ao;
                layoutParams.height = l.s(this.mContext, d.e.ds110);
                removeView(this.dqm);
                addView(this.dqm, layoutParams);
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().aM(i == 1);
        tbPageContext.getLayoutMode().aM(this.mRootView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fZj != null) {
            com.baidu.tbadk.browser.a.R(this.mContext, this.fZj.bBH());
        }
    }

    public ImageView getIcon() {
        return this.jt;
    }
}
