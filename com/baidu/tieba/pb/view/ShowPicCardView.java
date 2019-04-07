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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class ShowPicCardView extends FrameLayout implements View.OnClickListener {
    private boolean cCe;
    private LinearLayout eNG;
    private com.baidu.tieba.tbadkCore.data.a hGe;
    private TbImageView hGf;
    private TextView hGg;
    private Context mContext;
    private ImageView mIcon;
    private View mRootView;
    private TextView mTitle;

    public ShowPicCardView(Context context) {
        this(context, null, 0);
    }

    public ShowPicCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShowPicCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cCe = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.hGe;
    }

    public void setSupportNoImage() {
        this.cCe = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.pic_show_cardview_layout, (ViewGroup) this, true);
        this.hGf = (TbImageView) findViewById(d.g.pic_img);
        this.eNG = (LinearLayout) findViewById(d.g.bottom_ll);
        this.mTitle = (TextView) findViewById(d.g.title_ll);
        this.hGg = (TextView) findViewById(d.g.desc_ll);
        this.mIcon = (ImageView) findViewById(d.g.show_pic_icon);
    }

    public void setIconResId(int i) {
        al.c(this.mIcon, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.hGe != aVar) {
            this.hGe = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(aVar.getTitle());
            } else {
                this.mTitle.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.hGg.setVisibility(0);
                this.hGg.setText(aVar.getDescription());
            } else {
                this.hGg.setVisibility(8);
            }
            if (this.cCe) {
                this.hGf.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.hGf.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.hGf.setOnClickListener(this);
                this.hGf.setInterceptOnClick(true);
                this.hGf.setDefaultResource(d.f.icon_click);
                this.hGf.startLoad(aVar.cdN(), 18, false);
                int aO = l.aO(this.mContext) - (l.h(this.mContext, d.e.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (aO * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (aO * 0.75f);
                } else {
                    i = (int) (f * aO);
                }
                this.hGf.setLayoutParams(new FrameLayout.LayoutParams(aO, i));
                removeView(this.hGf);
                addView(this.hGf);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eNG.getLayoutParams();
                layoutParams.width = aO;
                layoutParams.height = l.h(this.mContext, d.e.ds110);
                removeView(this.eNG);
                addView(this.eNG, layoutParams);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hGe != null) {
            com.baidu.tbadk.browser.a.ar(this.mContext, this.hGe.cdO());
        }
    }

    public ImageView getIcon() {
        return this.mIcon;
    }
}
