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
    private boolean cCf;
    private LinearLayout eNH;
    private com.baidu.tieba.tbadkCore.data.a hGf;
    private TbImageView hGg;
    private TextView hGh;
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
        this.cCf = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.hGf;
    }

    public void setSupportNoImage() {
        this.cCf = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.pic_show_cardview_layout, (ViewGroup) this, true);
        this.hGg = (TbImageView) findViewById(d.g.pic_img);
        this.eNH = (LinearLayout) findViewById(d.g.bottom_ll);
        this.mTitle = (TextView) findViewById(d.g.title_ll);
        this.hGh = (TextView) findViewById(d.g.desc_ll);
        this.mIcon = (ImageView) findViewById(d.g.show_pic_icon);
    }

    public void setIconResId(int i) {
        al.c(this.mIcon, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.hGf != aVar) {
            this.hGf = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(aVar.getTitle());
            } else {
                this.mTitle.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.hGh.setVisibility(0);
                this.hGh.setText(aVar.getDescription());
            } else {
                this.hGh.setVisibility(8);
            }
            if (this.cCf) {
                this.hGg.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.hGg.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.hGg.setOnClickListener(this);
                this.hGg.setInterceptOnClick(true);
                this.hGg.setDefaultResource(d.f.icon_click);
                this.hGg.startLoad(aVar.cdN(), 18, false);
                int aO = l.aO(this.mContext) - (l.h(this.mContext, d.e.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (aO * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (aO * 0.75f);
                } else {
                    i = (int) (f * aO);
                }
                this.hGg.setLayoutParams(new FrameLayout.LayoutParams(aO, i));
                removeView(this.hGg);
                addView(this.hGg);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eNH.getLayoutParams();
                layoutParams.width = aO;
                layoutParams.height = l.h(this.mContext, d.e.ds110);
                removeView(this.eNH);
                addView(this.eNH, layoutParams);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hGf != null) {
            com.baidu.tbadk.browser.a.ar(this.mContext, this.hGf.cdO());
        }
    }

    public ImageView getIcon() {
        return this.mIcon;
    }
}
