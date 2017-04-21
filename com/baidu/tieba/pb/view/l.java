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
    private boolean aNY;
    private com.baidu.tieba.tbadkCore.data.a eyr;
    private TbImageView eys;
    private LinearLayout eyt;
    private ImageView eyu;
    private TextView eyv;
    private Context mContext;
    private View mRootView;
    private TextView mTitle;

    public l(Context context) {
        this(context, null, 0);
    }

    public l(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aNY = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.eyr;
    }

    public void Jc() {
        this.aNY = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(w.j.pic_show_cardview_layout, (ViewGroup) this, true);
        this.eys = (TbImageView) findViewById(w.h.pic_img);
        this.eyt = (LinearLayout) findViewById(w.h.bottom_ll);
        this.mTitle = (TextView) findViewById(w.h.title_ll);
        this.eyv = (TextView) findViewById(w.h.desc_ll);
        this.eyu = (ImageView) findViewById(w.h.show_pic_icon);
    }

    public void setIconResId(int i) {
        aq.c(this.eyu, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.eyr != aVar) {
            this.eyr = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(aVar.getTitle());
            } else {
                this.mTitle.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.eyv.setVisibility(0);
                this.eyv.setText(aVar.getDescription());
            } else {
                this.eyv.setVisibility(8);
            }
            if (this.aNY) {
                this.eys.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.eys.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.eys.setOnClickListener(this);
                this.eys.setInterceptOnClick(true);
                this.eys.setDefaultResource(w.g.icon_click);
                this.eys.c(aVar.biH(), 18, false);
                int af = com.baidu.adp.lib.util.k.af(this.mContext) - (com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (af * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (af * 0.75f);
                } else {
                    i = (int) (f * af);
                }
                this.eys.setLayoutParams(new FrameLayout.LayoutParams(af, i));
                removeView(this.eys);
                addView(this.eys);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eyt.getLayoutParams();
                layoutParams.width = af;
                layoutParams.height = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds110);
                removeView(this.eyt);
                addView(this.eyt, layoutParams);
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().aj(i == 1);
        tbPageContext.getLayoutMode().t(this.mRootView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eyr != null) {
            com.baidu.tbadk.browser.f.S(this.mContext, this.eyr.biI());
        }
    }

    public ImageView getIcon() {
        return this.eyu;
    }
}
