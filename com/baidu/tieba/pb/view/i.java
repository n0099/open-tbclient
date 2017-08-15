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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class i extends FrameLayout implements View.OnClickListener {
    private boolean aSb;
    private com.baidu.tieba.tbadkCore.data.a fcr;
    private TbImageView fcs;
    private LinearLayout fct;
    private ImageView fcu;
    private TextView fcv;
    private Context mContext;
    private View mRootView;
    private TextView mTitle;

    public i(Context context) {
        this(context, null, 0);
    }

    public i(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aSb = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.fcr;
    }

    public void Jc() {
        this.aSb = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.j.pic_show_cardview_layout, (ViewGroup) this, true);
        this.fcs = (TbImageView) findViewById(d.h.pic_img);
        this.fct = (LinearLayout) findViewById(d.h.bottom_ll);
        this.mTitle = (TextView) findViewById(d.h.title_ll);
        this.fcv = (TextView) findViewById(d.h.desc_ll);
        this.fcu = (ImageView) findViewById(d.h.show_pic_icon);
    }

    public void setIconResId(int i) {
        ai.c(this.fcu, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.fcr != aVar) {
            this.fcr = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(aVar.getTitle());
            } else {
                this.mTitle.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.fcv.setVisibility(0);
                this.fcv.setText(aVar.getDescription());
            } else {
                this.fcv.setVisibility(8);
            }
            if (this.aSb) {
                this.fcs.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.fcs.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.fcs.setOnClickListener(this);
                this.fcs.setInterceptOnClick(true);
                this.fcs.setDefaultResource(d.g.icon_click);
                this.fcs.c(aVar.bsB(), 18, false);
                int ag = k.ag(this.mContext) - (k.g(this.mContext, d.f.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (ag * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (ag * 0.75f);
                } else {
                    i = (int) (f * ag);
                }
                this.fcs.setLayoutParams(new FrameLayout.LayoutParams(ag, i));
                removeView(this.fcs);
                addView(this.fcs);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fct.getLayoutParams();
                layoutParams.width = ag;
                layoutParams.height = k.g(this.mContext, d.f.ds110);
                removeView(this.fct);
                addView(this.fct, layoutParams);
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().ah(i == 1);
        tbPageContext.getLayoutMode().t(this.mRootView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fcr != null) {
            com.baidu.tbadk.browser.a.T(this.mContext, this.fcr.bsC());
        }
    }

    public ImageView getIcon() {
        return this.fcu;
    }
}
