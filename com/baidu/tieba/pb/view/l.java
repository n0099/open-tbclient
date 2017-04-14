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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class l extends FrameLayout implements View.OnClickListener {
    private boolean aNW;
    private com.baidu.tieba.tbadkCore.data.a evZ;
    private TbImageView ewa;
    private LinearLayout ewb;
    private ImageView ewc;
    private TextView ewd;
    private Context mContext;
    private View mRootView;
    private TextView mTitle;

    public l(Context context) {
        this(context, null, 0);
    }

    public l(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aNW = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.evZ;
    }

    public void Jc() {
        this.aNW = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(w.j.pic_show_cardview_layout, (ViewGroup) this, true);
        this.ewa = (TbImageView) findViewById(w.h.pic_img);
        this.ewb = (LinearLayout) findViewById(w.h.bottom_ll);
        this.mTitle = (TextView) findViewById(w.h.title_ll);
        this.ewd = (TextView) findViewById(w.h.desc_ll);
        this.ewc = (ImageView) findViewById(w.h.show_pic_icon);
    }

    public void setIconResId(int i) {
        aq.c(this.ewc, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.evZ != aVar) {
            this.evZ = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(aVar.getTitle());
            } else {
                this.mTitle.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.ewd.setVisibility(0);
                this.ewd.setText(aVar.getDescription());
            } else {
                this.ewd.setVisibility(8);
            }
            if (this.aNW) {
                this.ewa.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.ewa.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.ewa.setOnClickListener(this);
                this.ewa.setInterceptOnClick(true);
                this.ewa.setDefaultResource(w.g.icon_click);
                this.ewa.c(aVar.bhG(), 18, false);
                int af = com.baidu.adp.lib.util.k.af(this.mContext) - (com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (af * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (af * 0.75f);
                } else {
                    i = (int) (f * af);
                }
                this.ewa.setLayoutParams(new FrameLayout.LayoutParams(af, i));
                removeView(this.ewa);
                addView(this.ewa);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ewb.getLayoutParams();
                layoutParams.width = af;
                layoutParams.height = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds110);
                removeView(this.ewb);
                addView(this.ewb, layoutParams);
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().aj(i == 1);
        tbPageContext.getLayoutMode().t(this.mRootView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.evZ != null) {
            com.baidu.tbadk.browser.f.S(this.mContext, this.evZ.bhH());
        }
    }

    public ImageView getIcon() {
        return this.ewc;
    }
}
